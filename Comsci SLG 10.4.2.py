temp = int(input("What is the temperature outside?: "))

if temp >= 0 and temp <= 40:
    print("The temperature is good today!")
    print("Go outside!")
elif temp < 0 or temp > 40:
    print("The temperature is not good today.")
    print("Stay inside.")