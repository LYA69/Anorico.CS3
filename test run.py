from math import log

# manual input
# a = int(input("a = "))
# b = int(input("b = "))

def numbers(a, b):
    if a > 20 or a < 10 or b > 20 or b < 10:
        print("False")
    else:
        print("True")


    print(f"product {a}*{b} = {a*b}")
    print(f"quotient {a}/{b} = {a/b}")
    print(f"sum {a}+{b} = {a+b}")
    print(f"difference {a}-{b} = {a-b}")
    print(f"exponent {a}^n = {b} ==> n = {log(b, a)}")
    # if you need b^n = a then replace last line with this one:
    # print(f"exponent {b}^n = {a} ==> n = log(a, b")
    print(f"floor division [{a}/{b}] = {a//b}")

    
a = 25
b = 12

numbers(a, b)