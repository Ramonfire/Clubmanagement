import { TestBed } from '@angular/core/testing';

import { AuthentificationService } from './auth.service';

describe('AuthService', () => {
  let service: AuthentificationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthentificationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
