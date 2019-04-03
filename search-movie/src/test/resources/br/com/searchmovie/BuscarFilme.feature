#language: pt

Funcionalidade: Buscar filmes e seus diretores
  Como um usuario que adora filmes
  Quero navegar no site do google
  Para que eu possa obter resultados de filmes e diretores

  @BuscarFilmes
  Cenário: Buscar filmes
    Dado que eu acesso o "Google"
    Quando no campo de busca eu digitar "Transformers"
    E eu clicar no botao "Pesquisa Google"
    Entao eu verei mais de "170.000.000" resultados
