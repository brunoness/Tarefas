# calcule a complexidade de tempo das soluções da série de Fibonacci
# apresentadas no módulo e compare as duas.

# Implementação recursiva pura
def fibo(n):
    if n <= 1:
        return n;
    return fibo(n-1) + fibo(n-2);

print('RECURSIVIDADE PURA')
print('12ª posição do array = 13ª da sequencia de Fibonacci =', fibo(12));

print('30ª posição do array = 31ª da sequencia de Fibonacci =', fibo(30));

# Descomente a linha a baixo para ver o erro "Maximum Recursion Depth Exceeded"
#print('1000ª posição do array = 1001ª da sequencia de Fibonacci =', fibo(1000));

print(' ');

# Implementação dinâmica
memo_fib = {};

def fibonacci_dp(n):
    if n in memo_fib:
        return memo_fib[n];
    if n == 0 or n == 1:
        memo_fib[n] = n;
    else:
        memo_fib[n] = fibonacci_dp(n-1) + fibonacci_dp(n-2);
    return memo_fib[n];

print('RECURSIVIDADE DINAMICA')

print('12ª posição do array = 13ª da sequencia de Fibonacci =', fibonacci_dp(12));

print('30ª posição do array = 31ª da sequencia de Fibonacci =', fibonacci_dp(30));

print('1000ª posição do array = 1001ª da sequencia de Fibonacci =', fibonacci_dp(1000))


# Recursiva pura:       Tempo:O(2^n)	    Espaço:O(n)
# Recursiva dinamica:   Tempo:O(n)	        Espaço:O(n)

# A implementação recursiva pura tem complexidade exponencial, pois 
# recalcula os mesmos valores várias vezes.
# já a implementação dinâmica armazena os resultados intermediários, 
# reduzindo a complexidade, o que a torna muito mais eficiente para 
# valores maiores é muito mais eficiente e prática para números grandes.