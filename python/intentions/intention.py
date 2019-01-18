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

    def run(self, text=""):
        if text is not "":
            self.__text = text
        for i in range(2, len(self.__tokenList)):
            if self.__inText(self.__tokenList[0]) and self.__inText(self.__tokenList[1])  and self.__inText(self.__tokenList[i]):
                return self.__text
        for i in range(1, len(self.__tokenList)):
            if self.__inText(self.__tokenList[0]) and self.__inText(self.__tokenList[i]):
                return  self.__retText(0,i) + self.__retText(i,i+1)

    def getEntities(self, text=""):
        if text is not "":
            self.__text = text
        listEntities = []
        i = 0
        encontrado = False
        for token in self.__tokenList:         
            if self.__inText(token):
                for j in range(i+1, len( self.__tokenList)):         
                    if self.__inText(self.__tokenList[j]):
                        encontrado = True
                        listEntities.append(self.__getEntity(i, j))
                        i = j
                        break
                if not encontrado:
                    listEntities.append(self.__getEntity(i, i+1))
                encontrado = False
        return listEntities
            

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

