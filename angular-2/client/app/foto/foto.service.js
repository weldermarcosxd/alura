"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var http_1 = require("@angular/http");
var cadastro_message_1 = require("../cadastro/cadastro.message");
var FotoService = (function () {
    function FotoService(http) {
        this.url = 'v1/fotos';
        this.http = http;
        this.headers = new http_1.Headers();
        this.headers.append('Content-type', 'application/json');
    }
    FotoService.prototype.findList = function () {
        return this.http.get(this.url).map(function (res) { return res.json(); });
    };
    FotoService.prototype.findById = function (id) {
        return this.http.get(this.url + "/" + id).map(function (res) { return res.json(); });
    };
    FotoService.prototype.persist = function (foto) {
        if (foto._id) {
            return this.http.put(this.url + "/" + foto._id, JSON.stringify(foto), { headers: this.headers })
                .map(function () { return new cadastro_message_1.CadastroMessage("Foto alterada com sucesso", false); });
        }
        else {
            return this.http.post(this.url, JSON.stringify(foto), { headers: this.headers }).
                map(function () { return new cadastro_message_1.CadastroMessage("Foto inserida com sucesso", true); });
            ;
        }
    };
    FotoService.prototype.update = function (foto) {
        return this.http.put(this.url + "/" + foto._id, JSON.stringify(foto), { headers: this.headers });
    };
    FotoService.prototype.delete = function (foto) {
        return this.http.delete(this.url + "/" + foto._id);
    };
    return FotoService;
}());
FotoService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_1.Http])
], FotoService);
exports.FotoService = FotoService;
//# sourceMappingURL=foto.service.js.map