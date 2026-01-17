package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.service.AirportService;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceIMPL implements AirportService {
    @Override
    public AirportDTO saveAirport(AirportDTO airportDTO) {
        airportDTO.setAirportId(IDGenerator.airportIDGen());
        System.out.println("Airport is from service layer: "+airportDTO);
        return airportDTO;
    }

    @Override
    public AirportDTO getSelectedAirport(String airportId) {
        System.out.println("Airport ID is: "+airportId);
        return new AirportDTO("APT-f5deaf73-1c27-4be3-98dd-73483ef8cb4e",
                "CMB", "Bandaranayake International Airport", "Katunayaka", "SL");
    }

    @Override
    public List<AirportDTO> getAllAirports() {
        return List.of(
                new AirportDTO("APT-f5deaf73-1c27-4be3-98dd-73483ef8cb4e",
                        "CMB", "Bandaranayake International Airport", "Katunayaka", "SL"),
                new AirportDTO("APT-2b3c4d5e-2222-4bbb-9ccc-2345678901bc",
                        "HRI", "Mattala Rajapaksa International Airport", "Hambantota", "SL"),

                new AirportDTO("APT-3c4d5e6f-3333-4ccc-7ddd-3456789012cd",
                        "JAF", "Jaffna International Airport", "Jaffna", "SL"),

                new AirportDTO("APT-4d5e6f70-4444-4ddd-6eee-4567890123de",
                        "TRR", "China Bay Airport", "Trincomalee", "SL"),

                new AirportDTO("APT-5e6f7081-5555-4eee-5fff-5678901234ef",
                        "BTC", "Batticaloa Airport", "Batticaloa", "SL"),

                new AirportDTO("APT-6f708192-6666-4fff-4aaa-6789012345fa",
                        "GIU", "Sigiriya Airport", "Sigiriya", "SL"),

                new AirportDTO("APT-708192a3-7777-4aaa-3bbb-7890123456ab",
                        "ACJ", "Anuradhapura Airport", "Anuradhapura", "SL"),

                new AirportDTO("APT-8192a3b4-8888-4bbb-2ccc-8901234567bc",
                        "RML", "Ratmalana Airport", "Colombo", "SL"),

                new AirportDTO("APT-92a3b4c5-9999-4ccc-1ddd-9012345678cd",
                        "KCT", "Koggala Airport", "Galle", "SL"),

                new AirportDTO("APT-a3b4c5d6-aaaa-4ddd-0eee-0123456789de",
                        "DWO", "Diyawanna Airport", "Sri Jayawardenepura Kotte", "SL")
        );
    }

    @Override
    public void deleteAirport(String airportId) {
        System.out.println("Deleted airport: "+airportId);
    }

    @Override
    public void updateAirport(String airportId, AirportDTO airportDTO) {
        airportDTO.setAirportId(airportId);
        System.out.println("Updated updatedAirport ID: "+airportId);
        System.out.println("Updated updatedAirport details: "+airportDTO);

    }
}
