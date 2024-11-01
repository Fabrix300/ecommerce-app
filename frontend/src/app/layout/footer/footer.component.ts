import { Component } from '@angular/core';
import { NgIconsModule } from '@ng-icons/core';

@Component({
  standalone: true,
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.scss',
  imports: [NgIconsModule],
})
export class FooterComponent {}
