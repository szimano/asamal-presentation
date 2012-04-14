package pl.devcrowd.model;

import pl.softwaremill.common.cdi.validation.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Tweet {

    @NotNull
    @Length(min = 5)
    private String msg;

    private Date date;

    public Tweet() {
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMsg() {
        return msg;
    }

    public Date getDate() {
        return date;
    }
}
