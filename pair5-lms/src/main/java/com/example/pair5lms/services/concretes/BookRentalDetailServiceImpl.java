package com.example.pair5lms.services.concretes;

import com.example.pair5lms.entities.BookRentalDetail;
import com.example.pair5lms.repositories.BookLocationRepository;
import com.example.pair5lms.repositories.BookRentalDetailRepository;
import com.example.pair5lms.services.abstracts.BookRentalDetailService;
import com.example.pair5lms.services.dtos.requests.bookrentaldetail.AddBookRentalDetailRequest;
import com.example.pair5lms.services.dtos.requests.bookrentaldetail.UpdateBookRentalDetailRequest;
import com.example.pair5lms.services.dtos.responses.bookrentaldetail.*;
import com.example.pair5lms.services.mappers.BookRentalDetailMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class BookRentalDetailServiceImpl implements BookRentalDetailService {
    private BookRentalDetailRepository bookRentalDetailRepository;
    private BookLocationRepository bookLocationRepository;
    private static final double PENALTY_PER_DAY=0.75;
    @Override
    public AddBookRentalDetailResponse add(AddBookRentalDetailRequest request) {

        // bookRentalWithSameIdShouldNotExist(Integer.toString(request.getBookLocationId()));
        BookRentalDetail bookRentalDetail= BookRentalDetailMapper.INSTANCE.bookRentalDetailFromAddRequest(request);
        bookRentalDetail=bookRentalDetailRepository.save(bookRentalDetail);
        AddBookRentalDetailResponse addBookRentalDetailResponse=BookRentalDetailMapper.INSTANCE.addResponseFromBookRentalDetail(bookRentalDetail);
        return addBookRentalDetailResponse;

    }

    @Override
    public UpdateBookRentalDetailResponse update(UpdateBookRentalDetailRequest request) {
        //    bookRentalWithSameIdShouldNotExist(Integer.toString(request.getBookLocationId()));

        //  calculatePenaltyForRentalBook(bookRentalDetail);
        BookRentalDetail  bookRentalDetail= BookRentalDetailMapper.INSTANCE.bookRentalDetailFromUpdateRequest(request);
        bookRentalDetail=bookRentalDetailRepository.save(bookRentalDetail);
        UpdateBookRentalDetailResponse updateBookRentalDetailResponse=BookRentalDetailMapper.INSTANCE.updateResponseFromBookRentalDetail(bookRentalDetail);
        return updateBookRentalDetailResponse;

    }

    @Override
    public DeleteBookRentalDetailResponse delete(int id) {
        BookRentalDetail bookRentalDetail=bookRentalDetailRepository.findById(id).orElseThrow();

        DeleteBookRentalDetailResponse deleteBookRentalDetailResponse=BookRentalDetailMapper.INSTANCE.deleteResponseFromId(bookRentalDetail);

        bookRentalDetailRepository.delete(bookRentalDetail);

        return deleteBookRentalDetailResponse;
    }

    @Override
    public List<ListBookRentalDetailResponse> getAll() {

        List<BookRentalDetail> bookRentalDetails=bookRentalDetailRepository.findAll();

        List<ListBookRentalDetailResponse>  bookRentalDetailResponses=BookRentalDetailMapper.INSTANCE.listResponseFromBookRentalDetails(bookRentalDetails);

        return bookRentalDetailResponses;
    }

    @Override
    public GetBookRentalDetailResponse getById(int id) {
        BookRentalDetail bookRentalDetail=bookRentalDetailRepository.findById(id).orElseThrow();
        GetBookRentalDetailResponse getBookRentalDetailResponse=BookRentalDetailMapper.INSTANCE.getBookRentalDetailResponseFromBookRentalDetail(bookRentalDetail);

        return getBookRentalDetailResponse;
    }
//    private void bookRentalWithSameIdShouldNotExist(String bookLocation)
//    {
//        Optional<BookRentalDetail>bookRentalWithSameId = bookRentalDetailRepository
//                .findByIdIgnoreCase(bookLocation);
//
//        if(bookRentalWithSameId.isPresent())
//            throw new BusinessException("bu kitap zaten ödünç alınmıştır");
//    }
    //  private void calculatePenaltyForRentalBook(BookRentalDetail bookRentalDetail){
//     Optional<BookRentalDetail> calculatePenalty=bookRentalDetailRepository.findByBookRentalId(bookRentalId);
//     if(calculatePenalty.isPresent()){
//         BookRentalDetail bookRentalDetail=calculatePenalty.get();
//         LocalDateTime currentDate=calculatePenalty.get().getRentalEndDate();
//         LocalDateTime returnDate=calculatePenalty.get().getRentalReturnDate();
//         long daysLate=Math.max(0, ChronoUnit.DAYS.between(returnDate,currentDate));
//         double penaltyAmount=daysLate*PENALTY_PER_DAY;
//         if(penaltyAmount>0){
//             applyPenalty(bookRentalDetail,penaltyAmount);
//         }}
//        throw new BusinessException("Book rental not found!");
//
//     }
//     private  void applyPenalty(BookRentalDetail bookRentalDetail,double penaltyAmount){
//        bookRentalDetail.setBookPrice(penaltyAmount);
//        bookRentalDetailRepository.save(bookRentalDetail);
//     }
//private void calculatePenaltyForRentalBook(){
//
//        BookRentalDetail bookRentalDetail;
//        LocalDateTime currentDate=bookRentalDetail.getRentalEndDate();
//        LocalDateTime returnDate=bookRentalDetail.getRentalReturnDate();
//        long daysLate=Math.max(0, ChronoUnit.DAYS.between(returnDate,currentDate));
//    double penaltyAmount=daysLate*PENALTY_PER_DAY;
//         if(penaltyAmount>0){
//             applyPenalty(bookRentalDetail,penaltyAmount);
//         }}
//    private  void applyPenalty(BookRentalDetail bookRentalDetail,double penaltyAmount){
//       bookRentalDetail.setBookPrice(penaltyAmount);
//       bookRentalDetailRepository.save(bookRentalDetail);
//     }

}




