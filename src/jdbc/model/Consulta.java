package jdbc.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Consulta {
   private int id;
   private int petId;
   private LocalTime horaInicio;
   private LocalTime horaFim;
   private LocalDate diaConsulta;

    public Consulta(int id, int petId, LocalTime horaInicio, LocalTime horaFim, LocalDate diaConsulta) {
        this.id = id;
        this.petId = petId;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.diaConsulta = diaConsulta;
    }

    public Consulta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }
       
    public LocalDate getDiaConsulta() {
        return diaConsulta;
    }

    public void setDiaConsulta(LocalDate diaConsulta) {
        this.diaConsulta = diaConsulta;
    }
    
public Timestamp convertTimeStamp(LocalDate diaConsulta, LocalTime horaInicio) {
    LocalDateTime diaHora = LocalDateTime.of(diaConsulta, horaInicio);
    Timestamp timeStamp = Timestamp.valueOf(diaHora);
    return timeStamp;
}
}
