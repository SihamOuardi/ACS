package acs.message.riskIndicator;

public class MerchantRiskIndicator {

	private String deliveryEmailAddress;
	private String deliveryTimeframe;
	private String giftCardAmount;
	private String giftCardCount;
	private String giftCardCurr;
	private String preOrderDate;
	private String preOrderPurchaseInd;
	private String reorderItemsInd;
	private String shipIndicator;
	
	
	
	public MerchantRiskIndicator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MerchantRiskIndicator(String deliveryEmailAddress, String deliveryTimeframe, String giftCardAmount,
			String giftCardCount, String giftCardCurr, String preOrderDate, String preOrderPurchaseInd,
			String reorderItemsInd, String shipIndicator) {
		super();
		this.deliveryEmailAddress = deliveryEmailAddress;
		this.deliveryTimeframe = deliveryTimeframe;
		this.giftCardAmount = giftCardAmount;
		this.giftCardCount = giftCardCount;
		this.giftCardCurr = giftCardCurr;
		this.preOrderDate = preOrderDate;
		this.preOrderPurchaseInd = preOrderPurchaseInd;
		this.reorderItemsInd = reorderItemsInd;
		this.shipIndicator = shipIndicator;
	}
	public String getDeliveryEmailAddress() {
		return deliveryEmailAddress;
	}
	public void setDeliveryEmailAddress(String deliveryEmailAddress) {
		this.deliveryEmailAddress = deliveryEmailAddress;
	}
	public String getDeliveryTimeframe() {
		return deliveryTimeframe;
	}
	public void setDeliveryTimeframe(String deliveryTimeframe) {
		this.deliveryTimeframe = deliveryTimeframe;
	}
	public String getGiftCardAmount() {
		return giftCardAmount;
	}
	public void setGiftCardAmount(String giftCardAmount) {
		this.giftCardAmount = giftCardAmount;
	}
	public String getGiftCardCount() {
		return giftCardCount;
	}
	public void setGiftCardCount(String giftCardCount) {
		this.giftCardCount = giftCardCount;
	}
	public String getGiftCardCurr() {
		return giftCardCurr;
	}
	public void setGiftCardCurr(String giftCardCurr) {
		this.giftCardCurr = giftCardCurr;
	}
	public String getPreOrderDate() {
		return preOrderDate;
	}
	public void setPreOrderDate(String preOrderDate) {
		this.preOrderDate = preOrderDate;
	}
	public String getPreOrderPurchaseInd() {
		return preOrderPurchaseInd;
	}
	public void setPreOrderPurchaseInd(String preOrderPurchaseInd) {
		this.preOrderPurchaseInd = preOrderPurchaseInd;
	}
	public String getReorderItemsInd() {
		return reorderItemsInd;
	}
	public void setReorderItemsInd(String reorderItemsInd) {
		this.reorderItemsInd = reorderItemsInd;
	}
	public String getShipIndicator() {
		return shipIndicator;
	}
	public void setShipIndicator(String shipIndicator) {
		this.shipIndicator = shipIndicator;
	}
	
	
	
}
