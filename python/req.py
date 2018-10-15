import requests
import re
import xlsxwriter

#import goslate
#gs = goslate.Goslate(service_urls=['http://translate.google.de'])
#from googletrans import Translator
titulo = ""
last_update = ""


with open('./lineas.txt', 'r',encoding='utf-8') as f:
    lineas = f.readlines()

workbook = xlsxwriter.Workbook('temporal.xlsx')
worksheet = workbook.add_worksheet()

index_excel = 2
for linea in lineas:
    url = "https://opendata.aragon.es/aod/services/web/datasets/"
    organizacion = ""
    organizacion1 = ""
    descripcion = ""
    desde = ""
    hasta = ""
    fecha = ""
    diccionario = ""
    licencia = ""
    mientras=""
    formatos = set()

    lineaaux = linea.split('\t')
    titulo = lineaaux[0]
    last_update = lineaaux[1]
    url1 = titulo.lower()
    url1 = url1.replace('.', '')
    url1 = url1.replace(',', '')
    url1 = url1.replace('(%)', '')
    url1 = url1.replace('%', '')
    url1 = url1.replace(': ', '-')
    url1 = url1.replace(':', '-')
    url1 = url1.replace('/', '-')
    url1 = url1.replace(' ( ', '-')
    url1 = url1.replace(' ) ', '-')
    url1 = url1.replace(' ', '-')
    url1 = url1.replace('INAGA CAZA ', '')
    url1 = url1.replace('INAGA ', '')
    url1 = url1.replace('ñ', 'ny')
    url1 = url1.replace('º', '')
    url1 = re.sub('-$','', url1)
    url1 = re.sub('[\{\}()]','', url1)
    url1 = url1.replace('á','a').replace('é','e').replace('í','i').replace('ó','o').replace('ú','u')
    url1 = url1.replace('Á','A').replace('É','E').replace('Í','I').replace('Ó','O').replace('Ú','U')
    cod = re.findall('(c[0-9][0-9]_d[0-9]+)$', url1)
    url1 = re.sub('(c[0-9][0-9]_d[0-9]+)$','', url1)
    url1 = re.sub('rss-de-','rss-', url1)
    if (cod):
        cod = str(cod).replace('[','')
        cod = cod.replace(']','')
        cod = cod.replace('\'','')
        url1 = url1 + cod + '_' + cod
    cod = re.findall('(^comarca)|(^municipio)', url1)
    url1 = re.sub('(^comarca)|(^municipio)','', url1)
    if (cod):
        cod = str(cod).replace('[','')
        cod = cod.replace(']','')
        cod = cod.replace('\'','')
        url1 = 'datos-'+ cod + url1
    url += url1


    page = requests.get(url)

    page = page.text.replace('\\\\u00f1', 'ñ')
    page = page.replace('\\\\u00d1', 'Ñ')
    page = page.replace('\\\\u00e1', 'á')
    page = page.replace('\\\\u00e9', 'é')
    page = page.replace('\\\\u00ed', 'í')
    page = page.replace('\\\\u00f3', 'ó')
    page = page.replace('\\\\u00fa', 'ú')
    page = page.replace('\\\\u00c1', 'Á')
    page = page.replace('\\\\u00c9', 'É')
    page = page.replace('\\\\u00cd', 'Í')
    page = page.replace('\\\\u00d3', 'Ó')
    page = page.replace('\\\\u00da', 'Ú')

    page = page.replace('\\u00f1', 'ñ')
    page = page.replace('\\u00d1', 'Ñ')
    page = page.replace('\\u00e1', 'á')
    page = page.replace('\\u00e9', 'é')
    page = page.replace('\\u00ed', 'í')
    page = page.replace('\\u00f3', 'ó')
    page = page.replace('\\u00fa', 'ú')
    page = page.replace('\\u00c1', 'Á')
    page = page.replace('\\u00c9', 'É')
    page = page.replace('\\u00cd', 'Í')
    page = page.replace('\\u00d3', 'Ó')
    page = page.replace('\\u00da', 'Ú')



    page = page.split("}, {")





    #print(page[4])
    #for item in page:

    

    for i in range(0, len(page)):
        if("organization" in page[i]):
            aux = re.findall('."[^"]*". ."is_organization', page[i])
            if aux :
                organizacion = str(aux).replace('\\','')
                organizacion = organizacion.replace('", "is_organization','')
                #organizacion = organizacion.replace('name": "','')
                organizacion = organizacion.replace('"','')
                organizacion = organizacion.replace('\'','')
                organizacion = organizacion.replace(']','')
                organizacion = organizacion.replace('[','')
            aux = re.findall('organization.": {[^}\[]*."[^"\[:]*.",', page[i])
            if aux:
                organizacion1 = str(aux).replace('\\','')
                organizacion1 = re.sub('organization": {[^}\[]*: "','',organizacion1)
                organizacion1 = organizacion1.replace('",','')
                organizacion1 = organizacion1.replace('"','')
                organizacion1 = organizacion1.replace('\'','')
                organizacion1 = organizacion1.replace(']','')
                organizacion1 = organizacion1.replace('[','')

        if("description" in page[i]):
            aux = re.findall('notes.": ."[^"]*". ."', page[i])
            if aux :
                descripcion = str(aux).replace('\\','')
                descripcion = descripcion.replace('notes": "','')
                descripcion = descripcion.replace('", "name','')
                descripcion = descripcion.replace(']','')
                descripcion = descripcion.replace('[','')
                descripcion = descripcion.replace('\'','')
                descripcion = descripcion.replace('",','')
                descripcion = descripcion.replace('"','')
        if("TemporalFrom" in page[i]):  
            aux = re.findall('TemporalFrom.", ."value.": ."[^"]*."', page[i])
            if aux :
                desde = str(aux).replace('\\','')
                desde = desde.replace('TemporalFrom", "value": "','')

        if("TemporalUntil" in page [i]):
            aux = re.findall('TemporalUntil.", ."value.": ."[^"]*."', page[i])
            if aux :
                hasta = str(aux).replace('\\','')
                hasta = hasta.replace('TemporalUntil", "value": "','')

        
        if("Data Dictionary" in page[i]):
            aux = re.findall('Data Dictionary URL0.", ."value.": ."[^"]*."', page[i])
            if aux :
                diccionario = str(aux).replace('\\','')
                diccionario = diccionario.replace('Data Dictionary URL0", "value": "','')
                diccionario = diccionario.replace('"','')
                diccionario = diccionario.replace(']','')
                diccionario = diccionario.replace('[','')
                diccionario = diccionario.replace('\'','')
            else:    
                aux = re.findall('value.": ."[^"]*.", ."key.": ."Data Dictionary URL0', page[i])  
                if(aux and diccionario is ""):
                    diccionario = str(aux).replace('\\','')
                    diccionario = diccionario.replace('", "key": "Data Dictionary URL0','')
                    diccionario = diccionario.replace('value": "','')
                    diccionario = diccionario.replace(']','')
                diccionario = diccionario.replace('[','')
                diccionario = diccionario.replace('\'','')

        if("license_title" in page[i]):
            aux = re.findall('license_title.": ."[^"]*."', page[i])
            if aux :
                licencia = str(aux).replace('\\','')
                licencia = licencia.replace('license_title": "','')
                licencia = licencia.replace('"','')
                licencia = licencia.replace('[','')
                licencia = licencia.replace(']','')
                licencia = licencia.replace('\'','')
        if("format" in page[i]):
            aux = re.findall('format.": ."[^"]*.",', page[i]) 
            if aux:
                formato = str(aux).replace('\\','')
                formato = formato.replace('format": "', '')
                formato = formato.replace('",', '')
                formato = formato.replace('"', '')  
                formato = formato.replace('[','')
                formato = formato.replace(']','')
                formato = formato.replace('\'','')
                formatos.add(formato)

        if(desde is "" and hasta is "" and "TemporalFrom" in page [i]):
            aux = re.findall('value.": ."[^}]*."TemporalFrom', page[i])
            if aux :
                #mientras = str(aux).replace('\\','')
                mientras = re.sub('[^0-9|-]','',str(aux))

    if(desde is ""):
        fecha = mientras
    else:
        fecha = desde + '-' + hasta
        fecha = fecha.replace('\'','')
        fecha = fecha.replace(']','')
        fecha = fecha.replace('[','')
        fecha = fecha.replace('"','')
    
    fecha = re.sub('-$','',fecha)
    if (organizacion is ""):
        organizacion = organizacion1
    organizacion = organizacion.replace('-',' ')
    
    formatoaux = "" 
    while(len(formatos)>0):
        formatoaux =formatoaux + "," + formatos.pop()


    
    #translator = Translator()
    
    #titulo = translator.translate(titulo, src='es', dest='en').text
    #descripcion = translator.translate(descripcion, src='es', dest='en').text
    #last_update = translator.translate(last_update, src='es', dest='en').text
    #organizacion = translator.translate(organizacion, src='es', dest='en').text
    
    #titulo = gs.translate(titulo, 'en', 'es')
    #descripcion = gs.translate(descripcion, 'en', 'es')
    #last_update = gs.translate(last_update, 'en', 'es')
    #organizacion = gs.translate(organizacion, 'en', 'es')
    worksheet.write('A'+str(index_excel), titulo)
    worksheet.write('B'+str(index_excel), descripcion)
    worksheet.write('C'+str(index_excel), last_update)
    worksheet.write('D'+str(index_excel), "")
    worksheet.write('E'+str(index_excel), organizacion)
    worksheet.write('F'+str(index_excel), "")
    worksheet.write('G'+str(index_excel), fecha)
    worksheet.write('H'+str(index_excel), licencia)
    worksheet.write('I'+str(index_excel), diccionario)
    worksheet.write('J'+str(index_excel), formatoaux)

    
    index_excel += 1

workbook.close()
