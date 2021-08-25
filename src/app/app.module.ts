import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule, routingConst } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { UserhomeComponent } from './userhome/userhome.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { UsersService } from './services/users.service';
import { RegistrationComponent } from './registration/registration.component';
import { UserdetailsComponent } from './userdetails/userdetails.component';
import { UserlistComponent } from './userlist/userlist.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { AirportServiceService } from './services/airport-service.service';
import { FlighthomepageComponent } from './flighthomepage/flighthomepage.component';
import { FlightService } from './services/flight.service';
import { BookingService } from './services/booking.service';
import { BookinghomeComponent } from './bookinghome/bookinghome.component';
import { ScheduledFlightHomePageComponent } from './scheduled-flight-home-page/scheduled-flight-home-page.component';
import { DeletescheduledFlightComponent } from './deletescheduled-flight/deletescheduled-flight.component';
import { ViewAllScheduledFlightComponent } from './view-all-scheduled-flight/view-all-scheduled-flight.component';
import { ScheduledFlightService } from './services/scheduled-flight.service';
import { DeleteUserConfirmationComponent } from './delete-user-confirmation/delete-user-confirmation.component';

@NgModule({
  declarations: [
    AppComponent,
    routingConst,
    DeleteUserConfirmationComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [UsersService,AirportServiceService,FlightService,BookingService,ScheduledFlightService],
  bootstrap: [AppComponent]
})
export class AppModule { }
