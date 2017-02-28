select pessoa.id as 'pessoa_id', pessoa.nome as 'pessoa.nome', foto.id as 'foto_id',
foto.nome as 'foto_nome', foto.tipo as 'foto_tipo',
foto_conteudo.conteudo_binario as 'foto_binario'
from pessoa
inner join foto on pessoa.foto = foto.id
inner join foto_conteudo on foto.binary_content = foto_conteudo.id;
