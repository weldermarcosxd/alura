select titular.id as 'titular_id',
titular.nome as 'titular_nome',
titular_f.data_nascimento as 'titular_dob',
categoria_titular.nome as 'titular_categoria',
situacao_titular.descricao as 'titular_situacao',
foto_titular.nome as 'titular_foto',
dependente.id as 'dependente_id',
dependente.nome as 'dependente_nome',
dependente_f.data_nascimento as 'dependente_dob',
categoria_dependente.nome as 'dependente_categoria',
situacao_dependente.descricao as 'dependente_situacao',
foto_dependente.nome as 'dependente_foto'
from pessoa as titular
inner join pessoa_fisica titular_f on titular.id = titular_f.id
left join pessoa_fisica dependente_f on titular.id = dependente_f.titular
inner join pessoa dependente on dependente_f.id = dependente.id
left join categoria categoria_titular on titular.categoria = categoria_titular.id
left join categoria categoria_dependente on dependente.categoria = categoria_dependente.id
left join situacao_pessoa situacao_titular on titular.situacao = situacao_titular.id
left join situacao_pessoa situacao_dependente on dependente.situacao = situacao_dependente.id
left join foto foto_titular on titular.foto = foto_titular.id
left join foto foto_dependente on dependente.foto = foto_dependente.id
order by titular.id, dependente.id;
