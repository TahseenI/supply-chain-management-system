import java.util.*;

/**
 *          
 * @author Gurpartap Sohi <a href="mailto:gurpartap.sohi@ucalgary.ca">
 *         gurpartap.sohi@ucalgary.ca</a>
 *         
 * @author Tahseen Intesar <a href="mailto:tahseen.intesar@ucalgary.ca">
 *         tahseen.intesar@ucalgary.ca</a>
 *         
 * @author Nabeel Amjad<a href="mailto:nabeel.amjad@ucalgary.ca">
 *         nabeel.amjad@ucalgary.ca</a>    
 *         
 * @version 1.0
 * @since 1.0
 */
public class InventoryHandler {
	private ArrayList<ArrayList<Furniture>> combinations = new ArrayList<ArrayList<Furniture>>();;
	private ArrayList<ArrayList<Furniture>> order = new ArrayList<ArrayList<Furniture>>();

	InventoryHandler(ArrayList<Furniture> furnitureData) {
		this.setCombinations(removeExcessCombinations(generateCombinations(furnitureData)));
	}

	public ArrayList<ArrayList<Furniture>> generateCombinations(ArrayList<Furniture> f) {
		ArrayList<ArrayList<Furniture>> frnt = new ArrayList<ArrayList<Furniture>>();
		ArrayList<Furniture> ft;
		boolean found = false;
		int n = f.get(0).getParts().length;
		if (n == 1) {
			for (int i = 0; i < f.size(); i++) {
				if (f.get(i).getParts()[n - 1] == 'Y') {
					found = true;
				}

				if (found == true) {
					ft = new ArrayList<Furniture>();
					ft.add(f.get(i));
					frnt.add(ft);
				}

				found = false;
			}

		} else if (n == 2) {
			for (int i = 0; i < f.size(); i++) {
				if (f.get(i).getParts()[n - 2] == 'Y' && f.get(i).getParts()[n - 1] == 'Y') {
					found = true;
				}

				if (found == true) {
					ft = new ArrayList<Furniture>();
					ft.add(f.get(i));
					frnt.add(ft);
				} else {
					for (int j = i + 1; j < f.size(); j++) {
						if ((f.get(i).getParts()[n - 2] == 'Y' || f.get(j).getParts()[n - 2] == 'Y')
								&& (f.get(i).getParts()[n - 1] == 'Y' || f.get(j).getParts()[n - 1] == 'Y')) {
							found = true;
						}

						if (found == true) {
							ft = new ArrayList<Furniture>();
							ft.add(f.get(i));
							ft.add(f.get(j));
							frnt.add(ft);
						}
						found = false;
					}
				}
				found = false;
			}
		} else if (n == 3) {

			for (int i = 0; i < f.size(); i++) {
				if (f.get(i).getParts()[n - 3] == 'Y' && f.get(i).getParts()[n - 2] == 'Y'
						&& f.get(i).getParts()[n - 1] == 'Y') {
					found = true;
				}

				if (found == true) {
					ft = new ArrayList<Furniture>();
					ft.add(f.get(i));
					frnt.add(ft);
				} else {
					if (i < i + 1) {
						for (int j = i + 1; j < f.size(); j++) {
							if ((f.get(i).getParts()[n - 3] == 'Y' || f.get(j).getParts()[n - 3] == 'Y')
									&& (f.get(i).getParts()[n - 2] == 'Y' || f.get(j).getParts()[n - 2] == 'Y')
									&& (f.get(i).getParts()[n - 1] == 'Y' || f.get(j).getParts()[n - 1] == 'Y')) {
								found = true;
							}

							if (found == true) {
								ft = new ArrayList<Furniture>();
								ft.add(f.get(i));
								ft.add(f.get(j));
								frnt.add(ft);
							} else {
								if (j < i + 2) {
									for (int k = i + 2; k < f.size(); k++) {
										if ((f.get(i).getParts()[n - 3] == 'Y' || f.get(j).getParts()[n - 3] == 'Y'
												|| f.get(k).getParts()[n - 3] == 'Y')
												&& (f.get(i).getParts()[n - 2] == 'Y'
														|| f.get(j).getParts()[n - 2] == 'Y'
														|| f.get(k).getParts()[n - 2] == 'Y')
												&& (f.get(i).getParts()[n - 1] == 'Y'
														|| f.get(j).getParts()[n - 1] == 'Y'
														|| f.get(k).getParts()[n - 1] == 'Y')) {
											found = true;
										}

										if (found == true) {
											ft = new ArrayList<Furniture>();
											ft.add(f.get(i));
											ft.add(f.get(j));
											ft.add(f.get(k));
											frnt.add(ft);
										}
										found = false;
									}
								}
							}
							found = false;
						}
					}
				}
				found = false;
			}
		} else if (n == 4) {
			for (int i = 0; i < f.size(); i++) {
				if (f.get(i).getParts()[n - 4] == 'Y' && f.get(i).getParts()[n - 3] == 'Y'
						&& f.get(i).getParts()[n - 2] == 'Y' && f.get(i).getParts()[n - 1] == 'Y') {
					found = true;
				}

				if (found == true) {
					ft = new ArrayList<Furniture>();
					ft.add(f.get(i));
					frnt.add(ft);
				} else {
					if (i < i + 1) {
						for (int j = i + 1; j < f.size(); j++) {
							if ((f.get(i).getParts()[n - 4] == 'Y' || f.get(j).getParts()[n - 4] == 'Y')
									&& (f.get(i).getParts()[n - 3] == 'Y' || f.get(j).getParts()[n - 3] == 'Y')
									&& (f.get(i).getParts()[n - 2] == 'Y' || f.get(j).getParts()[n - 2] == 'Y')
									&& (f.get(i).getParts()[n - 1] == 'Y' || f.get(j).getParts()[n - 1] == 'Y')) {
								found = true;
							}

							if (found == true) {
								ft = new ArrayList<Furniture>();
								ft.add(f.get(i));
								ft.add(f.get(j));
								frnt.add(ft);
							} else {
								if (j < i + 2) {
									for (int k = i + 2; k < f.size(); k++) {
										if ((f.get(i).getParts()[n - 4] == 'Y' || f.get(j).getParts()[n - 4] == 'Y'
												|| f.get(k).getParts()[n - 4] == 'Y')
												&& (f.get(i).getParts()[n - 3] == 'Y'
														|| f.get(j).getParts()[n - 3] == 'Y'
														|| f.get(k).getParts()[n - 3] == 'Y')
												&& (f.get(i).getParts()[n - 2] == 'Y'
														|| f.get(j).getParts()[n - 2] == 'Y'
														|| f.get(k).getParts()[n - 2] == 'Y')
												&& (f.get(i).getParts()[n - 1] == 'Y'
														|| f.get(j).getParts()[n - 1] == 'Y'
														|| f.get(k).getParts()[n - 1] == 'Y')) {
											found = true;
										}

										if (found == true) {
											ft = new ArrayList<Furniture>();
											ft.add(f.get(i));
											ft.add(f.get(j));
											ft.add(f.get(k));
											frnt.add(ft);
										} else {
											if (k < i + 3) {
												for (int l = i + 3; l < f.size(); l++) {
													if ((f.get(i).getParts()[n - 4] == 'Y'
															|| f.get(j).getParts()[n - 4] == 'Y'
															|| f.get(k).getParts()[n - 4] == 'Y'
															|| f.get(l).getParts()[n - 4] == 'Y')
															&& (f.get(i).getParts()[n - 3] == 'Y'
																	|| f.get(j).getParts()[n - 3] == 'Y'
																	|| f.get(k).getParts()[n - 3] == 'Y'
																	|| f.get(l).getParts()[n - 3] == 'Y')
															&& (f.get(i).getParts()[n - 2] == 'Y'
																	|| f.get(j).getParts()[n - 2] == 'Y'
																	|| f.get(k).getParts()[n - 2] == 'Y'
																	|| f.get(l).getParts()[n - 2] == 'Y')
															&& (f.get(i).getParts()[n - 1] == 'Y'
																	|| f.get(j).getParts()[n - 1] == 'Y'
																	|| f.get(k).getParts()[n - 1] == 'Y'
																	|| f.get(l).getParts()[n - 1] == 'Y')) {
														found = true;
													}

													if (found == true) {
														ft = new ArrayList<Furniture>();
														ft.add(f.get(i));
														ft.add(f.get(j));
														ft.add(f.get(k));
														ft.add(f.get(l));
														frnt.add(ft);
													}
													found = false;
												}
											}
										}
										found = false;
									}
								}
							}
							found = false;
						}
					}
				}
				found = false;
			}
		}
		return frnt;
	}

	public int findCheapest(ArrayList<ArrayList<Furniture>> frnt) {
		int min = 0;
		int p1 = 0;
		int p2 = 0;

		for (int j = 0; j < frnt.get(0).size(); j++) {
			p1 += frnt.get(0).get(j).getPrice();
		}

		for (int j = 0; j < frnt.size(); j++) {
			for (int k = 0; k < frnt.get(j).size(); k++) {
				p2 += frnt.get(j).get(k).getPrice();
			}
			if (p2 == p1) {
				if (frnt.get(j).size() < frnt.get(min).size()) {
					min = j;
					p1 = 0;
					for (int l = 0; l < frnt.get(min).size(); l++) {
						p1 += frnt.get(min).get(l).getPrice();
					}
				}
			} else if (p2 < p1) {
				min = j;
				p1 = 0;
				for (int l = 0; l < frnt.get(min).size(); l++) {
					p1 += frnt.get(min).get(l).getPrice();
				}
			}
			p2 = 0;
		}
		return min;
	}

	public boolean removeExcessCheck(ArrayList<ArrayList<Furniture>> frnt) {
		int k = 0;
		boolean found = false;
		for (int i = 0; i < frnt.size(); i++) {
			for (int j = 0; j < frnt.size(); j++) {
				if (frnt.get(i).size() < frnt.get(j).size()) {
					for (k = 0; k < frnt.get(i).size(); k++) {
						if (!frnt.get(j).contains(frnt.get(i).get(k))) {
							break;
						}
					}
					if (k == frnt.get(i).size()) {
						found = true;
						return found;
					}
				}
			}
		}
		return found;
	}

	public int removeExcess(ArrayList<ArrayList<Furniture>> frnt) {
		int k;
		int index = 0;
		for (int i = 0; i < frnt.size(); i++) {
			for (int j = 0; j < frnt.size(); j++) {
				if (frnt.get(i).size() < frnt.get(j).size()) {
					for (k = 0; k < frnt.get(i).size(); k++) {
						if (!frnt.get(j).contains(frnt.get(i).get(k))) {
							break;
						}
					}
					if (k == frnt.get(i).size()) {
						index = j;
						return index;
					}
				}
			}
		}
		return index;
	}

	public ArrayList<ArrayList<Furniture>> removeExcessCombinations(ArrayList<ArrayList<Furniture>> f) {
		ArrayList<ArrayList<Furniture>> fList = new ArrayList<ArrayList<Furniture>>(f);
		while (removeExcessCheck(fList)) {
			fList.remove(removeExcess(fList));
		}
		return fList;
	}

	public boolean combinationUsedCheck(ArrayList<ArrayList<Furniture>> source, ArrayList<ArrayList<Furniture>> order) {
		for (int i = 0; i < source.size(); i++) {
			for (int j = 0; j < order.size(); j++) {
				for (int k = 0; k < order.get(j).size(); k++) {
					if (source.get(i).contains(order.get(j).get(k))) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public int combinationUsedIndex(ArrayList<ArrayList<Furniture>> source, ArrayList<ArrayList<Furniture>> order) {
		int index = 0;
		for (int i = 0; i < source.size(); i++) {
			for (int j = 0; j < order.size(); j++) {
				for (int k = 0; k < order.get(j).size(); k++) {
					if (source.get(i).contains(order.get(j).get(k))) {
						index = i;
						return index;
					}
				}
			}
		}
		return index;
	}

	public ArrayList<ArrayList<Furniture>> removeUsedCombinations(ArrayList<ArrayList<Furniture>> source,
			ArrayList<ArrayList<Furniture>> order) {
		ArrayList<ArrayList<Furniture>> fList = new ArrayList<ArrayList<Furniture>>(source);
		while (combinationUsedCheck(fList, order) == true) {
			fList.remove(combinationUsedIndex(fList, order));
		}
		return fList;
	}

	public ArrayList<ArrayList<Furniture>> validateOrder(int n, ArrayList<ArrayList<Furniture>> f) {
		ArrayList<ArrayList<Furniture>> f2 = new ArrayList<ArrayList<Furniture>>(f);
		ArrayList<ArrayList<Furniture>> f3 = new ArrayList<ArrayList<Furniture>>();
		int i;

		for (i = 0; i < n; i++) {
			if (!f2.isEmpty()) {
				int index = findCheapest(f2);
				f3.add(f2.get(index));
				f2 = removeUsedCombinations(f2, f3);
			} else {
				break;
			}
		}
		/*
		 * if(i == n) { displayCombinations(f3); System.out.println("Valid Order");
		 * return true; } else { System.out.println("Invalid Order"); return false; }
		 */
		return f3;
	}

	public void displayCombinations(ArrayList<ArrayList<Furniture>> f) {
		for (int i = 0; i < f.size(); i++) {
			System.out.print("Combination " + i + ": ");
			for (int j = 0; j < f.get(i).size(); j++) {
				System.out.print(f.get(i).get(j).getID() + " ");
				System.out.print(" $" + f.get(i).get(j).getPrice() + " ");
			}
			System.out.println();
		}
	}

	public void displayCheapestCombination(ArrayList<ArrayList<Furniture>> f) {
		int index = findCheapest(f);
		int total = 0;
		System.out.println("Cheapest combination occurs at index " + index + ".");
		for (int i = 0; i < f.get(index).size(); i++) {
			total += f.get(index).get(i).getPrice();
		}
		System.out.println("Cheapest combination will cost: $" + total + ".");
	}

	public void displayOrder() {
		for (int i = 0; i < this.getOrder().size(); i++) {
			System.out.print("Order " + i + ": ");
			for (int j = 0; j < this.getOrder().get(i).size(); j++) {
				System.out.print(this.getOrder().get(i).get(j).getID() + " ");
				System.out.print(" $" + this.getOrder().get(i).get(j).getPrice() + " ");
			}
			System.out.println();
		}
	}

	public ArrayList<ArrayList<Furniture>> getCombinations() {
		return this.combinations;
	}

	public ArrayList<ArrayList<Furniture>> getOrder() {
		return this.order;
	}

	public void setCombinations(ArrayList<ArrayList<Furniture>> fr) {
		this.combinations = fr;
	}

	public void setOrder(ArrayList<ArrayList<Furniture>> fr_Order) {
		this.order = fr_Order;
	}

}