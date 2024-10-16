class Pokemon:
    _lastDamage = 0

    def __init__(self, name, hp, attack, defense = 1):
        self.name = name
        self.hp = hp
        self.attack = attack
        self.defense = defense

    def DoDameg(self):
        return self.attack

    def TakeDameg(self, Damage):
        EffectiveDam = (Damage / self.defense)
        self.hp = self.hp - EffectiveDam
        if (self.hp < 0):
            self.hp = 0
        self._lastDamage = EffectiveDam

    def IsDead(self):
        if (self.hp == 0):
            return True
        return False

def Battle(Pokemon1, Pokemon2):
    TurnCounter = 1

    #Pokemon1 will attack first
    EvenTurn = True
    while (True):
        if (EvenTurn):
            Attacker = Pokemon1
            Defender = Pokemon2
        if (not EvenTurn):
            Attacker = Pokemon2
            Defender = Pokemon1

        
        Defender.TakeDameg(Attacker.DoDameg())

        print("Turno:"+str(TurnCounter)+ "\n")
        print("Attacker " + Attacker.name+" hp:"+str(Attacker.hp))
        print("Defender " + Defender.name+" hp:"+str(Defender.hp))
        print(Defender.name+" takes:"+str(Defender._lastDamage)+" damage\n")

        if (Defender.IsDead()):
            print(Attacker.name + " Wins! on trurn "+str(TurnCounter))
            break
        
        TurnCounter = TurnCounter + 1
        EvenTurn = not EvenTurn


Pica = Pokemon("Pica", 100, 75, 1)
Roccia = Pokemon("Roccia", 200, 25, 2)
Battle(Pica, Roccia)

