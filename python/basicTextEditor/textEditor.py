# -*- coding: utf-8 -*-

import sys
# revisión de la versión
if sys.version[0] == '2' :
    #2.7.x
    from Tkinter import *
    import tkFileDialog as filedialog
    print("adads")
else:
    #3.x.x
    from tkinter import *
    import tkinter.filedialog as filedialog

#ventana principal
principal = Tk()


class TextEditor:
    @staticmethod
    def quit_app(event = None):
        principal.quit()

    def open_file(self, event = None):
        text_file = filedialog.askopenfilename(parent = principal, initialdir='~/')
        if text_file:
            self.text_area.delete(1.0, END)
            with open(text_file) as _file:
                self.text_area.insert(1.0, _file.read())
                principal.update_idletasks()

    def save_file(self, event = None):
        file = filedialog.asksaveasfile(mode = 'w')
        if file != None:
            data = self.text_area.get('1.0', END + '-1c')
            file.write(data)
            file.close()

    def __init__(self, principal):
        self.text_write = ""
        principal.title("Text-Editor")
        principal.geometry("800x600")
        cuadro = Frame(principal, width = 800, height = 600)
        scrollbar = Scrollbar(cuadro)
        self.text_area = Text(cuadro, width = 800, height = 600,
                            yscrollcommand = scrollbar.set, padx = 15, pady = 15)
        scrollbar.config(command = self.text_area.yview)
        scrollbar.pack(side = "right", fill = "y")
        self.text_area.pack(side = "left", fill = "both", expand = True)
        cuadro.pack()
        menu_bar = Menu(principal)
        file_menu = Menu(menu_bar, tearoff = 0)
        file_menu.add_command(label = "Abrir", command = self.open_file)
        file_menu.add_command(label = "Guardar", command = self.save_file)
        file_menu.add_command(label = "Cerrar", command = self.quit_app)
        menu_bar.add_cascade(label = "Archivo", menu=file_menu)
        principal.config(menu = menu_bar)
