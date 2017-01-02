<?php

  class Ebook extends Livro{

    private $watermark;

    public function getWatermark(){
      return $this->watermark;
    }

    public function setWatermark($watermark){
      $this->watermark = $watermark;
    }

    public function atualizaBaseadoEm($params){
      $this->setIsbn($params["isbn"]);
      $this->setWatermark($params["watermark"]);
    }
  }
