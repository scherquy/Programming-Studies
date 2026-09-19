'''
Leia valor da compra e valor pago e calcule o troco.

Se o pagamento for menor, mostre quanto ainda falta.
'''

valor_compra = float(input("\nInforme o valor do produto: "))

valor_pago = float(input("\nInforme o valor pago pelo cliente: ")) 

if valor_pago > valor_compra:
    valor_troco = valor_pago - valor_compra
    print(f"\nCompra finalizada. O troco é de R$ {valor_troco:.2f}\n")

elif valor_pago == valor_compra:
    print("\nCompra finalizada. Não é necessário troco.\n")

else:
    print(f"\nO cliente ainda deve pagar R$ {valor_compra - valor_pago:.2f} para finalizar a compra\n")