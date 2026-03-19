class ItemNode:
    def __init__(self, item_id, name, quantity, price):
        self.item_id, self.name, self.quantity, self.price = item_id, name, quantity, price
        self.next = None

class InventoryList:
    def __init__(self):
        self.head = None

    def add_item(self, item_id, name, quantity, price):
        new_node = ItemNode(item_id, name, quantity, price)
        new_node.next = self.head
        self.head = new_node

    def update_quantity(self, item_id, new_quantity):
        curr = self.head
        while curr:
            if curr.item_id == item_id:
                curr.quantity = new_quantity
                return
            curr = curr.next

    def total_value(self):
        total = 0
        curr = self.head
        while curr:
            total += (curr.quantity * curr.price)
            curr = curr.next
        return total