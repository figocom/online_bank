package figo.devops.bogate.mapper;


import lombok.SneakyThrows;
import org.mapstruct.Mapper;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;




@Mapper(componentModel = "spring")
public interface MapstructUtils {

    long FIFTY_YEARS_IN_MS = 1577836800000L;
    @SneakyThrows
    default Time stringToTime(String strTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return new Time(sdf.parse(strTime).getTime());
    }

    default String timeToString(Time time) {
        return time.toString();
    }

    default Time longToTime(Long mills) {
        return new Time(mills);
    }

    default Long timeToLong(Time time) {
        return time.getTime() + FIFTY_YEARS_IN_MS;
    }

    default Long timestampToMills(Timestamp timestamp) {
        return timestamp != null ? timestamp.getTime() : null;
    }

    default Long dateToMills(Date date) {
        return date.getTime();
    }

    default Timestamp longToTimestamp(Long aLong) {
        return new Timestamp(aLong);
    }

    default LocalDateTime longToLocalDateTime(Long aLong) {
        if (aLong != null) {
            return LocalDateTime.ofInstant(Instant.ofEpochMilli(aLong), ZoneId.systemDefault());
        } else {
            return null;
        }
    }

    default LocalDate longToLocalDate(Long aLong) {
        if (aLong != null) {
            return LocalDate.ofInstant(Instant.ofEpochMilli(aLong), ZoneId.systemDefault());
        } else {
            return null;
        }
    }

    default Long localDateTimeToLong(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        } else {
            return null;
        }
    }

    default Long localDateToLong(LocalDate localDate) {
        if (localDate != null) {
            return localDate.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
        } else {
            return null;
        }
    }

    default Long localTimeToLong(LocalTime localTime) {
        if (localTime != null) {
            return (localTime.toSecondOfDay() * 1000L) + FIFTY_YEARS_IN_MS;
        } else {
            return null;
        }
    }

    default LocalTime longToLocalTime(Long millis) {
        if (millis != null) {
            return Instant.ofEpochMilli(millis)
                    .atZone(ZoneId.systemDefault())
                    .toLocalTime();
        } else {
            return null;
        }
    }

    default Date longToDate(Long aLong) {
        return new Date(aLong);
    }

}
