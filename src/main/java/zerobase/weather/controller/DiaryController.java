package zerobase.weather.controller;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import zerobase.weather.domain.Diary;
import zerobase.weather.service.DiaryService;
import java.time.LocalDate;
import java.util.List;

@RestController

public class DiaryController {
    // 어떤 api를 제공할지 생각해보기 ,저장할땐 Post형식 많이사용함,데이터 형식 고정
    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService){
        this.diaryService = diaryService;
    }
    @ApiOperation("뀨")

  @PostMapping ("/create/diary")
     void createDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                      LocalDate date, @RequestBody String text){
      diaryService.createDiary(date, text);

  }

    @GetMapping("/read/diary")
    List<Diary> readDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                          LocalDate date){

                return diaryService.readDiary(date);
    }


    @GetMapping("/read/diaries")
    List<Diary> readDiaries
            (@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
             @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){
        return diaryService.readDiaries(startDate, endDate);

    }
    @PutMapping("/update/diary")
    void updateDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate date,
           @RequestBody String text) {
        diaryService.updateDiary(date, text);
    }
    @DeleteMapping("/delete/diary")
    void deleteDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate date){
        diaryService.deleteDiary(date);
    }


}