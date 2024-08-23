
/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day
 * in the future to sell that stock. Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 */
def max_stock_profit(prices: Array[Int]): Int =
  var max_profit = 0
  var l = 0
  var r = 0
  while r < prices.length do
    max_profit = math.max(max_profit, prices(r) - prices(l))
    if prices(r) < prices(l) then l = r else r += 1
  max_profit
