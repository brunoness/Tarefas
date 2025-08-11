#Problema: crie um código que calcule o fatorial de um número

def fatorial(n):
    if n == 0 or n == 1:
        return 1
    return n * fatorial(n - 1)


print('Fatorial de 3 =', fatorial(3))
print('Fatorial de 7 =', fatorial(7))
print('Fatorial de 12 =', fatorial(12))
print('Fatorial de 100 =', fatorial(100))
print(' ')
#print(fatorial(1000)) Remover o # para ver o erro de recursão máxima.

# Cada linguagem tem sua limitação porem é possível calcular o fatorial de 100 e de outros números muito grandes dentro do limite.
# portanto não é recomendado fazer dessa forma, nos próximos exercícios vamos ver como resolver isso de forma mais eficiente.

