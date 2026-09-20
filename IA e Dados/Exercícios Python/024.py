'''
Leia uma frase e conte quantas vogais ela possui.

Critério de conclusão: Ignore diferença entre maiúsculas e minúsculas.

Desafio extra: Mostre a contagem individual de a, e, i, o, u.
'''
soma_a = int(0)
soma_e = int(0)
soma_i = int(0)
soma_o = int(0)
soma_u = int(0)

frase = str(input("\nDigite uma frase: "))

frase_formatada = frase.strip().lower().replace(" ", "").replace("á", "a").replace("ã", "a").replace("â", "a").replace("à", "a").replace("é", "e").replace("ẽ", "e").replace("ê", "e").replace("è", "e").replace("í", "i").replace("õ", "o").replace("ô", "o").replace("ò", "o").replace("ú", "u").replace("ũ", "u").replace("û", "u").replace("ù", "u")

for x in range(0, len(frase_formatada), 1):
    match frase_formatada[x]:
        case "a": soma_a += 1
        case "e": soma_e += 1
        case "i": soma_i += 1
        case "o": soma_o += 1
        case "u": soma_u += 1

print(f"\nEssa frase contém:")
print(f"\n{soma_a} letras A")
print(f"{soma_e} letras E")
print(f"{soma_i} letras I")
print(f"{soma_o} letras O")
print(f"{soma_u} letras U\n")