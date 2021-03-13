#language: pt

@Pedidos
Funcionalidade: Abertura de pedidos no app

  Contexto: Login no App
    Dado que efetuo o login no app

    @TestZe-001 @AndroidValidado
    Cenario: [Pedidos] - Validar fluxo de seleção de produto
      Dado que seleciono o endereço de entrega
      E seleciono um produto
      Quando seleciono a quantidade
      Então valido o produto e a quantidade selecionada