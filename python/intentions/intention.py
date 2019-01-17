# -*- coding: utf-8 -*-
class EngineClass():
    

    def __init__(self, text = "", tokenList=[]):
        self.__text = text
        self.__tokenList = tokenList
        self.__markers = [". ", "." "-"]

    def settext(self, text):
        self.__text = text

    def gettext(self, text):
        return self.__text

    def run(self, text):
        self.__text = text
        if self.__inText(self.__tokenList[0]) and self.__inText(self.__tokenList[1])  and self.__inText(self.__tokenList[2]):
            return self.__text
        for i in range(1, len(self.__tokenList)):
            if self.__inText(self.__tokenList[0]) and self.__inText(self.__tokenList[i]):
                return  self.__retText(self.__text)
            

    # private
    def __inText(self, token):
        return self.__clearToken(token) in self.__text

    def __getEntity(self, numb1, numb2):
        return self.__text.split(self.__tokenList[numb1])[1].split(self.__tokenList[numb2])[0]

    def __clearToken(self, token):
        for mark in self.__markers:
            token = token.replace(mark, "")
        return token

    def __retText(self, index):
        ret = self.__tokenList[0] + self.__getEntity(0,index)
        return ret


