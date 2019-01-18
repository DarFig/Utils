# -*- coding: utf-8 -*-
class EngineClass():
    

    def __init__(self, text = "", tokenList=[]):
        self.__text = text
        self.__tokenList = tokenList
        self.__markers = [". ", " .",".","-"]

    def settext(self, text):
        self.__text = text

    def gettext(self, text):
        return self.__text

    def run(self, text):
        self.__text = text
        for i in range(2, len(self.__tokenList)):
            if self.__inText(self.__tokenList[0]) and self.__inText(self.__tokenList[1])  and self.__inText(self.__tokenList[i]):
                return self.__text
        for i in range(1, len(self.__tokenList)):
            if self.__inText(self.__tokenList[0]) and self.__inText(self.__tokenList[i]):
                return  self.__retText(0,i) + self.__retText(i,i+1)
            

    # private
    def __inText(self, token):
        return self.__clearToken(token) in self.__text

    def __getEntity(self, numb1, numb2):
        try:
            return self.__text.split(self.__clearToken(self.__tokenList[numb1]))[1].split(self.__clearToken(self.__tokenList[numb2]))[0]
        except:
            return self.__text.split(self.__clearToken(self.__tokenList[numb1]))[1]

    def __clearToken(self, token):
        token1 = token
        for mark in self.__markers:
            token1 = token1.replace(mark, "")
        return token1

    def __retText(self, i1, i2):
        ret = self.__tokenList[i1] + self.__getEntity(i1, i2)
        return ret


