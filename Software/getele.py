# coding=UTF-8
import re
import sys
import time
import requests

class ElectricQuery(object):

    def __init__(self):
        self.loginUrl = 'http://202.116.25.12/Login.aspx'
        self.defaultUrl = 'http://202.116.25.12/default.aspx'

        self.session = requests.Session()
        self.session.headers.update(
            {
                "user-agent":
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36",
            }
        )

    def Query(self, DormNum):
        self.DormNum = str(DormNum)
        # print("宿舍号: %s" % self.DormNum)

        # 先模拟登陆, Session会自动保存cookie
        self.Login()

        # 获取__VIEWSTATE、__EVENTVALIDATION
        info = self.GetInfo()
        self.__VIEWSTATE = info['__VIEWSTATE']
        self.__EVENTVALIDATION = info['__EVENTVALIDATION']

        self.RestPower()

    def Login(self):
        # 先模拟登陆, Session会自动保存cookie
        loginData = {
            "__LASTFOCUS": "",
            "__EVENTTARGET": "",
            "__EVENTARGUMENT": "",
            # __VIEWSTATE和__EVENTVALIDATION来源于login.aspx的html中
            "__VIEWSTATE": "/wEPDwULLTE5ODQ5MTY3NDlkZM4DISokA1JscbtlCdiUVQMwykIc",
            "__EVENTVALIDATION": "/wEWBQLz+M6SBQK4tY3uAgLEhISACwKd+7q4BwKiwImNC7oxDnFDxrZR6l5WlUJDrpGZXrmN",
            "__VIEWSTATEGENERATOR": "C2EE9ABB",
            "txtname": self.DormNum,
            # "hidtime": time.strftime('%F %X'),
            "txtpwd": "",
            "ctl01": "",
        }
        res = self.session.post(url=self.loginUrl, data=loginData)

    def GetInfo(self):
        # Returns:
        # 返回info是一个字典, 包含__VIEWSTATE、__EVENTVALIDATION

        res = self.session.get(url=self.defaultUrl)
        html_text = res.text
        # print("HTML: %s" % html_text)
        
        info = dict()
        regular = {
            '__VIEWSTATE': re.compile(r'id="__VIEWSTATE" value="(.+)" />'),
            '__EVENTVALIDATION': re.compile(r'id="__EVENTVALIDATION" value="(.+)" />'),
        }
        info['__VIEWSTATE'] = regular['__VIEWSTATE'].findall(html_text)[0]
        info['__EVENTVALIDATION'] = regular['__EVENTVALIDATION'].findall(html_text)[
            0]
       
         
        return info

    def RestPower(self):
        # Returns:
        # 输出剩余电量
        data = {
            "__VIEWSTATE": self.__VIEWSTATE,
            "__VIEWSTATEGENERATOR": "CA0B0334",
            "__EVENTVALIDATION": self.__EVENTVALIDATION,
            "__41_value": "00900200",
            "__41_last_value": "00000000",
            "__box_ajax_mark": "true",
        }

        res = self.session.post(url=self.defaultUrl, data=data)
        res = res.text
        res = re.findall(r'box.__27.setValue\("(.+?)"\)', res)[0]
        print("%s" % res)


if __name__ == "__main__":
    query = ElectricQuery()
    dorm = sys.argv[1]
    # dorm = "3313"
    query.Query(dorm)
