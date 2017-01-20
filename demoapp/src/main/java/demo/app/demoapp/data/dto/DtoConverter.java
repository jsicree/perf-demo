package demo.app.demoapp.data.dto;

import demo.app.demoapp.data.domain.FinancialInstrument;
import demo.app.demoapp.data.domain.FinancialRecord;

public final class DtoConverter {

	public DtoConverter() {
		// TODO Auto-generated constructor stub
	}

	public static FinancialInstrumentDto toFinancialInstrumentDto(FinancialInstrument fi) {
		FinancialInstrumentDto dto = new FinancialInstrumentDto();
		dto.setId(fi.getId());
		dto.setSymbol(fi.getSymbol());
		dto.setExchange(fi.getExchange());
		return dto;
	}

	public static FinancialRecordDto toFinancialRecordDto(FinancialRecord fr) {
		FinancialRecordDto dto = new FinancialRecordDto();
		dto.setId(fr.getId());
		dto.setFinancialInstrumentId(fr.getFinancialInstrument().getId());
		dto.setSymbol(fr.getFinancialInstrument().getSymbol());
		dto.setExchange(fr.getFinancialInstrument().getExchange());
		dto.setDate(fr.getDate());
		dto.setOpenPrice(fr.getOpenPrice());
		dto.setClosePrice(fr.getClosePrice());
		dto.setVolume(fr.getVolume());
		
		return dto;
	}
	
	
}
