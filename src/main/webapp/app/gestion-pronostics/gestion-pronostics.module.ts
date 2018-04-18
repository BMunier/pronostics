import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MonEcranComponent } from './mon-ecran/mon-ecran.component';
import { PronosticsSharedModule } from '../shared';
import { RouterModule } from '@angular/router';
import { gestPronoState } from '.';

@NgModule({
  imports: [
    CommonModule,
    PronosticsSharedModule,
    RouterModule.forChild(gestPronoState),
    /* jhipster-needle-add-admin-module - JHipster will add admin modules here */
  ],
  declarations: [MonEcranComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GestionPronosticsModule { }
