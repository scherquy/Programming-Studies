def media(lista):
  media = sum(lista) / len(lista)

  if media >= 6:
    situacao = "Aprovado"
  else:
    situacao = "Reprovado"

  return (media, situacao)



notas = [5, 5, 6]

media, situacao = media(notas)

print(f"\nA média do aluno é {media:.2f}. Aluno {situacao}\n")