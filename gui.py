import tkinter as tk
import mysql.connector


def validatelogin(user, passwd):
    sqlquery = "SELECT * FROM staff WHERE email='" + user + "' AND password='" + passwd + "';"
# Fill in your local database settings, having created the tables
    mydb = mysql.connector.connect(
        host ="localhost",
        user ="admin",
        password ="",
        database = "db1"
    )
    window.title(user)
    mycursor = mydb.cursor()
    mycursor.execute(sqlquery)
# Check if we can fetch the row
# Change this to if True, to skip database check
    if mycursor.fetchone() != None:
        window.title("Constella")
        usernameLabel.destroy()
        usernameEntry.destroy()
        passwordLabel.destroy()
        passwordEntry.destroy()
        loginButton.destroy()
        # Insert into shifts
        # Move to next module
    return


window = tk.Tk(className='Constella')
window.title("Constella Login")
window.geometry("800x600")
usernameLabel = tk.Label(window, text="Email Address")
usernameLabel.place(relx=0.4, rely=0.2)
# We have to use StringVar to work with the GUI https://www.oreilly.com/library/view/python-gui-programming/9781785283758/ch04s02.html
username = tk.StringVar()
usernameEntry = tk.Entry(window, textvariable=username)
usernameEntry.place(relx=0.4, rely=0.3)
passwordLabel = tk.Label(window,text="Password")
passwordLabel.place(relx=0.4, rely=0.4)
password = tk.StringVar()
passwordEntry = tk.Entry(window, textvariable=password, show='*')
passwordEntry.place(relx=0.4, rely=0.5)
# Without using lambda, the callback function is called with arguments as soon as the window is created
# and the button doesn't work
loginButton = tk.Button(window, text="Login", command=lambda: validatelogin(username.get(), password.get()))
loginButton.place(relx=0.46, rely=0.6)
window.mainloop()



