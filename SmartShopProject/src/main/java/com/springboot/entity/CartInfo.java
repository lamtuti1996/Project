package com.springboot.entity;

import java.util.ArrayList;
import java.util.List;

import com.springboot.entity.ProductInfo;

public class CartInfo {
	private int orderNum;

	private final List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();

	public CartInfo() {

	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public List<CartLineInfo> getCartLines() {
		return this.cartLines;
	}

	private CartLineInfo findLineByCode(int code) {
		for (CartLineInfo line : this.cartLines) {
			if (line.getProducs().getProductID() == code) {
				return line;
			}
		}
		return null;
	}

	public void addProduct(ProductInfo product, int quanlity) {
		CartLineInfo line = this.findLineByCode(product.getProductID());

		if (line == null) {
			line = new CartLineInfo();
			line.setQuantity(0);
			line.setProductInfo(product);
			this.cartLines.add(line);
		}
		int newQuantity = line.getQuantity() + quanlity;
		if (newQuantity <= 0) {
			this.cartLines.remove(line);
		} else {
			line.setQuantity(newQuantity);
		}
	}

	public void validate() {

	}

	public void updateProduct(int code, int quantity) {
		CartLineInfo line = this.findLineByCode(code);

		if (line != null) {
			if (quantity <= 0) {
				this.cartLines.remove(line);
			} else {
				line.setQuantity(quantity);
			}
		}
	}

	public void updateIncreaseQuality(int code) {
		CartLineInfo line = this.findLineByCode(code);
		if (line != null) {
			line.setQuantity(line.getQuantity() + 1);

		}

	}

	public void updateDecreaseQuality(int code) {
		CartLineInfo line = this.findLineByCode(code);
		if (line != null) {

			if (line.getQuantity() == 1) {
				this.cartLines.remove(line);
			} else {
				line.setQuantity(line.getQuantity() - 1);

			}

		}

	}

	public void removeProduct(ProductInfo product) {
		CartLineInfo line = this.findLineByCode(product.getProductID());
		if (line != null) {
			this.cartLines.remove(line);
		}
	}

	public boolean isEmpty() {
		return this.cartLines.isEmpty();
	}

	public int getQuantityTotal() {
		int quantity = 0;
		for (CartLineInfo line : this.cartLines) {
			quantity += line.getQuantity();
		}
		return quantity;
	}

	public double getAmountTotal() {
		double total = 0;
		for (CartLineInfo line : this.cartLines) {
			total += line.getAmount();
		}
		return total;
	}

	public void updateQuantity(CartInfo cartForm) {
		if (cartForm != null) {
			List<CartLineInfo> lines = cartForm.getCartLines();
			for (CartLineInfo line : lines) {
				this.updateProduct(line.getProducs().getProductID(), line.getQuantity());
			}
		}

	}

	public double getPriceTotal() {
		CartLineInfo line = new CartLineInfo();
		return line.getAmount();
	}

}
