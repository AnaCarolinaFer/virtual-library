## Biblioteca Virtual em Java

### Visão Geral
Este repositório contém o código fonte de uma biblioteca virtual desenvolvida em Java. A aplicação oferece ferramentas como busca, edição, inclusão, exclusão, viualização, upload e download de arquivos.
### Estrutura do Projeto
* **Classes Principais:**
  * **Itens:** Representa um item da biblioteca, contendo informações como título, autor, descrição, ISBN (chave primária), data de publicação e um conjunto de arquivos.
  * **ResultadoBusca:** Representa o resultado de uma busca, contendo informações sobre os itens encontrados.
  * **ListaCompletaResource:** Responsável por retornar a lista completa de itens.
  * **EditarResource:** Controla as operações de edição de um item.
  * **FileUploadService:** Realiza o upload de arquivos para a biblioteca.
  * **Incluir:** Classe relacionada à inclusão de novos itens.
  * **Itens:** Representa um item da biblioteca, contendo informações como título, autor, descrição, etc.
  * **ApagarResource:** Responsável por apagar um item da biblioteca.
  * **SalvarEditadoResourse:** Salva as alterações realizadas na edição de um item.
  * **BuscarFiltroResourse:** Realiza buscas filtradas por diversos critérios.
  * **ErroUpload:** Classe para tratamento de erros durante o upload de arquivos.
  * **ItemApplication:** Classe principal da aplicação.
  * **FileDownloadService:** Permite o download de arquivos da biblioteca.
  * **ItemResource:** Representa um recurso de item individual.
  * **VisualizarResource:** Permite a visualização detalhada de um item.
  * **UploadResource:** Controla as operações de upload.
  * **SalvarAdicionadoResource:** Salva um novo item adicionado à biblioteca.

* **Funcionalidades**
  * **Busca:** Permite buscar itens por título, autor, descrição e outros critérios.
  * **Inclusão:** Permite adicionar novos itens à biblioteca, incluindo o upload de arquivos.
  * **Edição:** Permite editar informações de itens existentes, como título, autor, descrição e arquivos.
  * **Exclusão:** Permite remover itens da biblioteca.
  * **Visualização:** Permite visualizar detalhes completos de um item, incluindo seus arquivos.
  * **Upload e Download:** Permite o upload e download de arquivos relacionados aos itens.
