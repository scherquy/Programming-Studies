notas = [6.0, 7.0, 9.0, 5.5, 8.0]
qualitativo = 0.5

notaFinal = map(lambda nota: nota + qualitativo, notas)
notaFinal = list(notaFinal)

print(notaFinal)