
class Engine():
    def __init__(self, text = "", tokenList=[]):
        self.__text = text
        self.__tokenList = tokenList

    def settext(self, text):
        self.__text = text

    def gettext(self, text):
        return self.__text

    def run(self, text):
        self.__text = text
        if __inText(__tokenList[0]) and __inText(__tokenList[1])  and __inText(__tokenList[2]):
                return ""
            for i in range(1, len(__tokenList)):
                if __inText(__tokenList[0]) and __inText(__tokenList[i])
                    return ""
            

    # private
    def __inText(self, token):
        return token in self.__text

    


