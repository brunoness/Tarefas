# Problema: resolva o exercício 2 com programação dinâmica. Crie um algoritmo
# com abordagem top down e outro com bottom up e explique as diferenças entre
# a solução do exercício 2 e a do exercício 3.


#TOP DOWN
memo = {}

def fatorial1(n):
    if n == 0 or n == 1:
        return 1
    if n not in memo:
        memo[n] = n * fatorial1(n - 1)
    return memo[n]

print('Fatorial de 5 =', fatorial1(7))

#BOTOM UP
def fatorial2(n):
    resultado = 1
    for i in range(2, n + 1):
        resultado *= i
    return resultado

print('Fatorial de 5 =', fatorial2(5))