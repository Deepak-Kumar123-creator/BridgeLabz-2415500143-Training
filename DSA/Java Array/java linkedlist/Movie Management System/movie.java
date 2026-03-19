class MovieNode:
    def __init__(self, title, director, year, rating):
        self.title, self.director, self.year, self.rating = title, director, year, rating
        self.prev = self.next = None

class MovieLinkedList:
    def __init__(self):
        self.head = self.tail = None

    def add_movie(self, title, director, year, rating):
        new_node = MovieNode(title, director, year, rating)
        if not self.head:
            self.head = self.tail = new_node
        else:
            self.tail.next = new_node
            new_node.prev = self.tail
            self.tail = new_node

    def remove_movie(self, title):
        curr = self.head
        while curr and curr.title != title:
            curr = curr.next
        if not curr: return
        if curr.prev: curr.prev.next = curr.next
        else: self.head = curr.next
        if curr.next: curr.next.prev = curr.prev
        else: self.tail = curr.prev

    def display_forward(self):
        curr = self.head
        while curr:
            print(f"{curr.title} ({curr.year}) - {curr.rating}/10")
            curr = curr.next

    def display_reverse(self):
        curr = self.tail
        while curr:
            print(f"{curr.title} ({curr.year}) - {curr.rating}/10")
            curr = curr.prev