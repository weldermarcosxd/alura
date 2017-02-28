#create resource
curl http://localhost:3000/pagamentos/pagamento -X POST -v -H "Content-type: application/json" -d @mock/data.json | json_pp

#confirm resource
curl http://localhost:3000/pagamentos/pagamento/11 -X PUT -v | json_pp

#cancel resource
curl http://localhost:3000/pagamentos/pagamento/11 -X DELETE
