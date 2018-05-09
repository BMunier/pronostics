import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { StadeModalService } from './stade-modal.service';
import { JhiLanguageHelper } from '../../shared';

import { StadeMgmntService } from './stade-management.service';
import { Stade } from './stade.model';

@Component({
    selector: 'jhi-stade-management-dialog',
    templateUrl: './stade-management-dialog.component.html',
    styles: []
})
export class StadeManagementDialogComponent implements OnInit {
    isSaving: Boolean;
    stade: Stade;
    constructor(
        public activeModal: NgbActiveModal,
        private languageHelper: JhiLanguageHelper,
        private stadeMgmntService: StadeMgmntService,
        private eventManager: JhiEventManager
    ) { }

    ngOnInit() {
        this.isSaving = false;
    }
    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.stade.id !== null) {
            this.stadeMgmntService.update(this.stade).subscribe((response) => this.onSaveSuccess(response), () => this.onSaveError());
        } else {
            this.stadeMgmntService.create(this.stade).subscribe((response) => this.onSaveSuccess(response), () => this.onSaveError());
        }
    }

    private onSaveSuccess(result) {
        this.eventManager.broadcast({ name: 'stadeListModification', content: 'OK' });
        this.isSaving = false;
        this.activeModal.dismiss(result.body);
    }

    private onSaveError() {
        this.isSaving = false;
    }

}
@Component({
    selector: 'jhi-stade-dialog',
    template: ''
})
export class StadeDialogComponent implements OnInit, OnDestroy {
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private stadeModalService: StadeModalService
    ) { }

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if (params['id']) {
                this.stadeModalService.open(StadeManagementDialogComponent as Component, params['id']);
            } else {
                this.stadeModalService.open(StadeManagementDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }

}




