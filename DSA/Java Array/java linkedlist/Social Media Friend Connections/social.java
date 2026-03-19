class UserNode:
    def __init__(self, user_id, name, age):
        self.user_id = user_id
        self.name = name
        self.age = age
        self.friends = [] # Nested array for friend IDs
        self.next = None

class SocialNetwork:
    def __init__(self):
        self.head = None

    def add_user(self, user_id, name, age):
        new_node = UserNode(user_id, name, age)
        new_node.next = self.head
        self.head = new_node

    def add_friend_connection(self, user_id1, user_id2):
        u1, u2 = self.search(user_id1), self.search(user_id2)
        if u1 and u2:
            u1.friends.append(user_id2)
            u2.friends.append(user_id1)

    def mutual_friends(self, user_id1, user_id2):
        u1, u2 = self.search(user_id1), self.search(user_id2)
        if u1 and u2:
            return list(set(u1.friends) & set(u2.friends))
        return []
        
    def search(self, user_id):
        curr = self.head
        while curr:
            if curr.user_id == user_id: return curr
            curr = curr.next
        return None