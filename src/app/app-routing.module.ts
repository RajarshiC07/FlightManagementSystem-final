import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { RegistrationComponent } from './registration/registration.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UserdetailsComponent } from './userdetails/userdetails.component';
import { UserhomeComponent } from './userhome/userhome.component';
import { UserlistComponent } from './userlist/userlist.component';
import { AirportListComponent } from './airport-list/airport-list.component';
import { AddAirportComponent } from './add-airport/add-airport.component';
import { ModifyAirportComponent } from './modify-airport/modify-airport.component';
import { SearchAirportComponent } from './search-airport/search-airport.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { DeleteAirportComponent } from './delete-airport/delete-airport.component';
import { HomePageComponent } from './home-page/home-page.component';
import { AddFlightComponent } from './add-flight/add-flight.component';
import { FlightListComponent } from './flight-list/flight-list.component';
import { AddBookingComponent } from './add-booking/add-booking.component';
import { AddPassengerComponent } from './add-passenger/add-passenger.component';
import { ConfirmBookingComponent } from './confirm-booking/confirm-booking.component'
import { UpdateBookingComponent } from './update-booking/update-booking.component';
import { ViewbyAirportComponent } from './viewby-airport/viewby-airport.component';
import { ViewbyFlightnumberComponent } from './viewby-flightnumber/viewby-flightnumber.component';
import { AddComponent } from './add-scheduledflight/add.component';
import { ModifyComponent } from './modify-scheduledflight/modify.component';
import { ViewAllComponent } from './view-all/view-all.component';
import { ViewByIdComponent } from './view-by-id/view-by-id.component';
import { ModifyFlightComponent } from './modify-flight/modify-flight.component';
import { DeleteFlightComponent } from './delete-flight/delete-flight.component';
import { SearchFlightComponent } from './search-flight/search-flight.component';
import { FlighthomepageComponent } from './flighthomepage/flighthomepage.component';
import { BookinghomeComponent } from './bookinghome/bookinghome.component';
import { ScheduledFlightHomePageComponent } from './scheduled-flight-home-page/scheduled-flight-home-page.component';
import { DeletescheduledFlightComponent } from './deletescheduled-flight/deletescheduled-flight.component';
import { ViewAllScheduledFlightComponent } from './view-all-scheduled-flight/view-all-scheduled-flight.component';
import { DeleteUserConfirmationComponent } from './delete-user-confirmation/delete-user-confirmation.component';


const routes: Routes = [
  {path:"",redirectTo:"login",pathMatch:"full"},
  {path:"scheduledflightHome-Page/ScheduledFlights", redirectTo:"ScheduledFlights",pathMatch:"full"},
  {path:"scheduledflightHome-Page/addScheduleFlights", redirectTo:"addScheduleFlights",pathMatch:"full"},
  {path:"scheduledflightHome-Page/viewScheduledFlightsByFlightNumber", redirectTo:"viewScheduledFlightsByFlightNumber",pathMatch:"full"},
  {path:"scheduledflightHome-Page/viewbyScheduledFlightsByAirport", redirectTo:"viewbyScheduledFlightsByAirport",pathMatch:"full"},
  {path:"scheduledflightHome-Page", component: ScheduledFlightHomePageComponent},
  {path:"ScheduledFlights", component: ViewAllScheduledFlightComponent},
  {path:"addScheduleFlights", component: AddComponent},
  {path:"viewScheduledFlightsByFlightNumber", component: ViewbyFlightnumberComponent},
  {path:"viewbyScheduledFlightsByAirport", component: ViewbyAirportComponent},
  {path:"modifyFlightsByFlightNumber", component: ModifyComponent},


  {path:"bookinghome/addBooking",redirectTo:"addBooking",pathMatch:"full"},
  {path:"bookinghome/viewAllBookings",redirectTo:"viewAllBookings",pathMatch:"full"},
  {path:"bookinghome" , component:BookinghomeComponent},
  {path:"addBooking" , component: AddBookingComponent},
  {path:"addPassenger" , component: AddPassengerComponent},
  {path:"ConfirmBooking" , component: ConfirmBookingComponent},
  {path:"modifyBooking/:bookingId" , component: UpdateBookingComponent},
  {path:"viewAllBookings", component: ViewAllComponent},
  {path:"bookingById/:bookingId" , component: ViewByIdComponent},

  {path: 'flighthome', component:FlighthomepageComponent},
  {path: 'flights', component: FlightListComponent},
  {path: 'add-flight', component: AddFlightComponent},
  {path: 'modify-flight/:flightNumber', component: ModifyFlightComponent},
  {path: 'search-flight/:flightNumber', component: SearchFlightComponent},

  {path:"login",component:LoginComponent},
  {path:"userhome",component:UserhomeComponent},
  {path:"adminhome",component:AdminhomeComponent},
  {path:"register",component:RegistrationComponent},
  {path:"userdetails",component:UserdetailsComponent},
  {path:"userlist",component:UserlistComponent},
  {path:"update",component:UpdateUserComponent},
  {path:"deleteuser",component:DeleteUserConfirmationComponent},

  {path: 'airporthome', component:HomePageComponent},
  {path: 'airports', component: AirportListComponent},
  {path: 'add-airport', component: AddAirportComponent},
  {path: 'modify-airport/:airportCode', component: ModifyAirportComponent},
  {path: 'search-airport/:airportCode', component: SearchAirportComponent},
  {path:'**',component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingConst = [LoginComponent,UserhomeComponent,AdminhomeComponent,PageNotFoundComponent,RegistrationComponent,UserdetailsComponent,UserlistComponent,UpdateUserComponent,AirportListComponent,AddAirportComponent,ModifyAirportComponent,SearchAirportComponent,DeleteAirportComponent,HomePageComponent,AddFlightComponent,
  FlightListComponent,
  ModifyFlightComponent,
  DeleteFlightComponent,
  SearchFlightComponent,
  FlighthomepageComponent,BookinghomeComponent, AddBookingComponent, AddPassengerComponent, ConfirmBookingComponent, UpdateBookingComponent, ViewAllComponent, ViewByIdComponent,ScheduledFlightHomePageComponent,  AddComponent,
  ViewbyFlightnumberComponent,
  ViewAllComponent,
  ModifyComponent,
  DeletescheduledFlightComponent,
  ViewbyAirportComponent,ViewAllScheduledFlightComponent,DeleteUserConfirmationComponent];