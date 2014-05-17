<?php

namespace Carpet\Bundle\PetBundle\Entity;

use Doctrine\ORM\Mapping as ORM;
use Gedmo\Mapping\Annotation as Gedmo;

/**
 * Possession
 *
 * @ORM\Table()
 * @ORM\HasLifecycleCallbacks()
 * @ORM\Entity
 */
class Possession
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;

    
    /**
     * @var datetime $created
     *
     * @Gedmo\Timestampable(on="create")
     * @ORM\Column(type="datetime")
     */
    private $created;
    
    
    /**
     * @var datetime $updated
     *
     * @Gedmo\Timestampable(on="update")
     * @ORM\Column(type="datetime")
     */
    private $updated;
    
    /**
     *
     * @var int
     * 
     * @ORM\Column(name="amount", type="integer")
     */
    private $amount;
    
    /**
     * @ORM\ManyToOne(targetEntity="Pet", inversedBy="possessions")
     * @ORM\JoinColumn(name="pet_id", referencedColumnName="id")
     */
    private $pet;
    
    
    /**
     * @ORM\ManyToOne(targetEntity="Gadget", inversedBy="possessions")
     * @ORM\JoinColumn(name="gadget_id", referencedColumnName="id")
     */
    private $gadget;

    
    /**
     * Get id
     *
     * @return integer 
     */
    public function getId()
    {
        return $this->id;
    }

    
    /**
     * Set pet
     *
     * @param \Carpet\Bundle\PetBundle\Entity\Pet $pet
     * @return Possession
     */
    public function setPet(\Carpet\Bundle\PetBundle\Entity\Pet $pet = null)
    {
        $this->pet = $pet;

        return $this;
    }

    /**
     * Get pet
     *
     * @return \Carpet\Bundle\PetBundle\Entity\Pet 
     */
    public function getPet()
    {
        return $this->pet;
    }

    /**
     * Set gadget
     *
     * @param \Carpet\Bundle\PetBundle\Entity\Gadget $gadget
     * @return Possession
     */
    public function setGadget(\Carpet\Bundle\PetBundle\Entity\Gadget $gadget = null)
    {
        $this->gadget = $gadget;

        return $this;
    }

    /**
     * Get gadget
     *
     * @return \Carpet\Bundle\PetBundle\Entity\Gadget 
     */
    public function getGadget()
    {
        return $this->gadget;
    }

    /**
     * Set amount
     *
     * @param integer $amount
     * @return Possession
     */
    public function setAmount($amount)
    {
        $this->amount = $amount;

        return $this;
    }

    /**
     * Get amount
     *
     * @return integer 
     */
    public function getAmount()
    {
        return $this->amount;
    }

    /**
     * Set created
     *
     * @param \DateTime $created
     * @return Possession
     */
    public function setCreated($created)
    {
        $this->created = $created;

        return $this;
    }

    /**
     * Get created
     *
     * @return \DateTime 
     */
    public function getCreated()
    {
        return $this->created;
    }

    /**
     * Set updated
     *
     * @param \DateTime $updated
     * @return Possession
     */
    public function setUpdated($updated)
    {
        $this->updated = $updated;

        return $this;
    }

    /**
     * Get updated
     *
     * @return \DateTime 
     */
    public function getUpdated()
    {
        return $this->updated;
    }
}
