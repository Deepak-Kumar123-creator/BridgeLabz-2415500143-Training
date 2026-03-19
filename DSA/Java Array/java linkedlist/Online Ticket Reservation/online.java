class TicketNode:
    def __init__(self, ticket_id, customer, movie, seat):
        self.ticket_id, self.customer, self.movie, self.seat = ticket_id, customer, movie, seat
        self.next = None

class TicketReservationSystem:
    def __init__(self):
        self.head = None

    def book_ticket(self, ticket_id, customer, movie, seat):
        new_node = TicketNode(ticket_id, customer, movie, seat)
        if not self.head:
            self.head = new_node
            self.head.next = self.head
        else:
            curr = self.head
            while curr.next != self.head:
                curr = curr.next
            curr.next = new_node
            new_node.next = self.head

    def display_tickets(self):
        if not self.head: return
        curr = self.head
        while True:
            print(f"[{curr.ticket_id}] {curr.customer} - {curr.movie} (Seat: {curr.seat})")
            curr = curr.next
            if curr == self.head: break