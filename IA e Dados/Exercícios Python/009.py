'''
Leia uma quantidade inteira de segundos e converta para horas, minutos e segundos restantes.

Faça o inverso: leia horas, minutos e segundos e converta para segundos.
'''

segundos = int(input("\nInforme os segundos: "))

horas = segundos // 3600
minutos = (segundos % 3600) // 60
seg = segundos % 60

print(f"\n{horas}h {minutos}min {seg}s\n")