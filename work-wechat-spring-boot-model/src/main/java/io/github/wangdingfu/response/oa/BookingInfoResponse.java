package io.github.wangdingfu.response.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.oa.BookingInfo;
import io.github.wangdingfu.response.AbstractBaseResponse;

import java.util.List;
import java.util.StringJoiner;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-07-20 13:19
 **/
public class BookingInfoResponse extends AbstractBaseResponse {

    @JsonProperty("booking_list")
    private List<BookingInfo> bookingList;

    public List<BookingInfo> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<BookingInfo> bookingList) {
        this.bookingList = bookingList;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BookingInfoResponse.class.getSimpleName() + "[", "]")
                .add("bookingList=" + bookingList)
                .toString();
    }
}
