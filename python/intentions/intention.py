# -*- coding: utf-8 -*-
class EngineClass():
 
    def __init__(self, text = "", tokenList=[]):
        self.__text = text
        self.__tokenList = tokenList

    def settext(self, text):
        self.__text = text

    def gettext(self, text):
        return self.__text

    def run(self, text):
        self.__text = text
        if self.__inText(self.__tokenList[0]) and self.__inText(self.__tokenList[1])  and self.__inText(self.__tokenList[2]):
            return ""
        for i in range(1, len(self.__tokenList)):
            if self.__inText(self.__tokenList[0]) and self.__inText(self.__tokenList[i]):
                return ""
            

    # private
    def __inText(self, token):
        return token in self.__text

    


