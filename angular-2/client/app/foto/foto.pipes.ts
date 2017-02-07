import { Pipe, PipeTransform } from '@angular/core';
import { FotoComponent } from './foto.component';

@Pipe({
    name: 'listFilter'
})
export class FotoPipes implements PipeTransform {
    transform(fotos: FotoComponent[], search: string) {
        return fotos.filter(foto => foto.titulo.toLowerCase().includes(search.toLowerCase()));
    }
}
