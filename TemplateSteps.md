# Passos para utilizar o Template

1. Criar uma nova organização

## Habilitando o GitHub Action
1. Ir nas configurações da Organização
2. Actions
3. General 
4. Workflow permissions
5. selecione `Read and write permissions`
6. Salve


## Configurando o template
1. usar o template `https://github.com/leandro-costa/blog-material-aula-template`
1. Modificar a informação `title` no arquivo [README.md](README.md)
1. Modificar a informação da ementa no arquivo [posts/ementa.md](posts/ementa.md)
1. Modificar as informação no arquivo [.vuepress/theme.ts](.vuepress/theme.ts)
   1. hostname
   1. author
   1. repo
   1. blog
1. Modificar a informação `base` no arquivo [.vuepress/config.ts](.vuepress/config.ts)
1. Modificar as informação no arquivo [.vuepress/public/manifest.json](.vuepress/public/manifest.json)
   1. name
   1. short_name

## Publicar

1. Ir nas configurações do repositório
2. Pages
3. Branch
4. selecionar `gh-pages`
5. salvar